package com.traveloka.poc.droolsengine.Service.impl;

import com.traveloka.poc.droolsengine.Service.PriceCalculator;
import com.traveloka.poc.droolsengine.domain.Item;
import org.drools.core.base.RuleNameMatchesAgendaFilter;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.AgendaFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceCalculatorImpl implements PriceCalculator {

    @Autowired
    private KieContainer kieContainer;

    @Override
    public Item setDiscount(Item item){
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(item);


        AgendaFilter agendaFilter = new RuleNameMatchesAgendaFilter("^\\d+$");
        kieSession.fireAllRules(agendaFilter);
        kieSession.dispose();
        return item;

    }
}
