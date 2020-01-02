package com.ctrip.framework.apollo.common.datasource;

import com.ctrip.framework.apollo.core.enums.Env;
import com.ctrip.framework.apollo.core.enums.EnvUtils;
import com.ctrip.framework.foundation.Foundation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TitanSettings {

  @Value("${sit.titan.url:}")
  private String sitTitanUrl;

  @Value("${uat.titan.url:}")
  private String uatTitanUrl;

  @Value("${pro.titan.url:}")
  private String proTitanUrl;

  @Value("${sit.titan.dbname:}")
  private String sitTitanDbname;

  @Value("${uat.titan.dbname:}")
  private String uatTitanDbname;

  @Value("${pro.titan.dbname:}")
  private String proTitanDbname;

  public String getTitanUrl() {
    Env env = EnvUtils.transformEnv(Foundation.server().getEnvType());
    switch (env) {
      case SIT:
        return sitTitanUrl;
      case UAT:
        return uatTitanUrl;
      case TOOLS:
      case PRO:
        return proTitanUrl;
      default:
        return "";
    }
  }

  public String getTitanDbname() {
    Env env = EnvUtils.transformEnv(Foundation.server().getEnvType());
    switch (env) {
      case SIT:
        return sitTitanDbname;
      case UAT:
        return uatTitanDbname;
      case TOOLS:
      case PRO:
        return proTitanDbname;
      default:
        return "";
    }
  }

}
