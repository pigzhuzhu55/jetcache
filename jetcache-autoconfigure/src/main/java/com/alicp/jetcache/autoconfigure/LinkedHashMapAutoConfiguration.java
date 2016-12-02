package com.alicp.jetcache.autoconfigure;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.embedded.LinkedHashMapCacheBuilder;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

/**
 * Created on 2016/12/2.
 *
 * @author <a href="mailto:yeli.hl@taobao.com">huangli</a>
 */
@Component
@Conditional(LinkedHashMapAutoConfiguration.LinkedHashMapCondition.class)
public class LinkedHashMapAutoConfiguration extends EmbeddedCacheAutoConfiguration {
    public LinkedHashMapAutoConfiguration() {
        super("linkedhashmap");
    }

    @Override
    protected Cache initCache(RelaxedPropertyResolver resolver, String cacheArea) {
        LinkedHashMapCacheBuilder builder = LinkedHashMapCacheBuilder.createLinkedHashMapCacheBuilder();
        parseGeneralConfig(builder, resolver);
        return builder.buildCache();
    }

    public static class LinkedHashMapCondition extends JetCacheConditon {
        public LinkedHashMapCondition() {
            super("linkedhashmap");
        }
    }
}