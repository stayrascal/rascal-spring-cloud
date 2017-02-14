package com.stayrascal.api.consul.bus.jaskson;

import com.fasterxml.jackson.databind.module.SimpleModule;

public class SubtypeModule extends SimpleModule {
    private Class<?>[] subtypes;

    public SubtypeModule(Class<?>... subtypes) {
        this.subtypes = subtypes;
    }

    @Override
    public void setupModule(SetupContext context) {
        context.registerSubtypes(subtypes);
        super.setupModule(context);
    }
}

