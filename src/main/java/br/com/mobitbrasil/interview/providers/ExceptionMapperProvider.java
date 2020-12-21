package br.com.mobitbrasil.interview.providers;

import br.com.mobitbrasil.interview.json.JsonHelper;
import lombok.val;
import org.javatuples.Pair;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collector;

import static java.util.stream.Collectors.groupingBy;
import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

@Provider
public class ExceptionMapperProvider implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException e) {
        return Response.status(BAD_REQUEST)
                .entity(prepareMessage(e))
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }

    private String prepareMessage(ConstraintViolationException exception) {
        val properties = new LinkedHashMap<String, Object>() {{
            put("status", BAD_REQUEST.getStatusCode());
            put("timestamp", Instant.now(Clock.system(ZoneId.of("America/Fortaleza"))).getEpochSecond());
        }};

        Map<String, HashSet<String>> errors = exception.getConstraintViolations()
                .stream()
                .map(error -> {
                    val input = error.getPropertyPath().toString().split("\\.")[2];
                    val value = error.getMessage();

                    return new Pair<>(input, value);
                }).collect(groupingBy(Pair::getValue0, Collector.of(HashSet<String>::new, (s, p) -> s.add(p.getValue1()), (s1, s2) -> {
                       s1.addAll(s2);
                       return s1;
                })));

        properties.put("errors", errors);

        return JsonHelper.gson.toJson(properties, LinkedHashMap.class);
    }
}
