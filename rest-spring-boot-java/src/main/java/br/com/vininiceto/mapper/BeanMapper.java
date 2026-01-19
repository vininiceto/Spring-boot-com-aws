package br.com.vininiceto.mapper;

import br.com.vininiceto.exception.RequiredObjectNullException;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

public class BeanMapper {

    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <O, D> D parseObject(O origin, Class<D> destination) {
        if (origin == null) {
            throw new RequiredObjectNullException();
        }
        return mapper.map(origin, destination);
    }

    public static <O, D> List<D> parseListObject(List<O> origin, Class<D> destination) {

        List<D> objectDestionation = new ArrayList<>();

        for (O o : origin) {
            objectDestionation.add(mapper.map(o, destination));
        }
        return objectDestionation;

    }



}
