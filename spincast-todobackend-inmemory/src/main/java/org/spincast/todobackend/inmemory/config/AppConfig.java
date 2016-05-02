package org.spincast.todobackend.inmemory.config;

import javax.annotation.Nullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spincast.core.guice.MainArgs;
import org.spincast.core.utils.ISpincastUtils;
import org.spincast.plugins.configpropsfile.SpincastConfigPropsFileBased;

import com.google.inject.Inject;

/**
 * Implementation of our application's configurations class.
 */
public class AppConfig extends SpincastConfigPropsFileBased implements IAppConfig {

    protected final Logger logger = LoggerFactory.getLogger(AppConfig.class);

    /**
     * Constructor
     */
    @Inject
    public AppConfig(ISpincastUtils spincastUtils,
                     @MainArgs @Nullable String[] mainArgs) {
        super(spincastUtils, mainArgs);
    }

    @Override
    public String getTodoUrlTemplate() {

        //==========================================
        // We use the URL prefix found in a config file,
        // or fallback to "localhost" if no config file is found.
        //==========================================
        String schemeHostPort = getConfig("app.server.scheme_host_port", "http://localhost:" + getHttpServerPort());

        //==========================================
        // A template for a Todo's URL looks like 
        // "http://example.com/todos/{{id}}".
        //==========================================
        return schemeHostPort + "/{{id}}";
    }

}
