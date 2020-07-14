package demo1;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.time.ZoneId;

@Component
public class ZoneIdFactoryBean implements FactoryBean<ZoneId> { //工厂模式,未使用
    String zone = "UTC+08:00";

    @Override
    public ZoneId getObject() {
        return ZoneId.of(zone);
    }

    @Override
    public Class<?> getObjectType() {
        return ZoneId.class;
    }
}
