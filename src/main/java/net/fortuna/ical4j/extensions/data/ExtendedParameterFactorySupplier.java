package net.fortuna.ical4j.extensions.data;

import net.fortuna.ical4j.data.DefaultParameterFactorySupplier;
import net.fortuna.ical4j.extensions.model.parameter.Filename;
import net.fortuna.ical4j.model.Parameter;
import net.fortuna.ical4j.model.ParameterFactory;
import net.fortuna.ical4j.model.parameter.Display;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class ExtendedParameterFactorySupplier implements Supplier<List<ParameterFactory<?>>> {

    @Override
    public List<ParameterFactory<? extends Parameter>> get() {
        List<ParameterFactory<? extends Parameter>> factories = new ArrayList<>(new DefaultParameterFactorySupplier().get());

        List<ParameterFactory<? extends Parameter>> extended = Arrays.asList(new Display.Factory(),
                new Filename.Factory());

        factories.addAll(extended);

        return factories;
    }
}
