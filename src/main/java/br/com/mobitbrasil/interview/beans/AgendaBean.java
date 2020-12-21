package br.com.mobitbrasil.interview.beans;

import br.com.mobitbrasil.interview.db.JpaRepository;
import br.com.mobitbrasil.interview.model.Agenda;

import javax.ejb.Stateless;

@Stateless
public class AgendaBean extends JpaRepository<Agenda> {
    protected AgendaBean() {
        super(Agenda.class);
    }
}
