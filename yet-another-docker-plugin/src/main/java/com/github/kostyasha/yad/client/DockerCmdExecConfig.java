package com.github.kostyasha.yad.client;

import java.io.Serializable;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Serializable object that store options for {@see com.github.kostyasha.yad.docker_java.jaxrs.DockerCmdExecFactoryImpl}
 * Required for {@see #DockerBuilderPublisher.class} that builds DockerClient on slave side
 * TODO create analogue in docker-java https://github.com/docker-java/docker-java/pull/379
 *
 * @author Kanstantsin Shautsou
 */
public class DockerCmdExecConfig implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Integer readTimeout; //sec
    private final Integer connectTimeout; //sec

    /**
     * @param readTimeout Value as is from docker-plugin DockerCloud configuration
     */
    public DockerCmdExecConfig(Integer readTimeout, Integer connectTimeout) {
        this.readTimeout = readTimeout;
        this.connectTimeout = connectTimeout;
    }

    public Integer getReadTimeout() {
        return readTimeout;
    }

    public Integer getConnectTimeout() {
        return connectTimeout;
    }

    /**
     * Helper methods that returns sec in ms for @see com.github.kostyasha.yad.docker_java.jaxrs.DockerCmdExecFactoryImpl
     */
    public Integer getReadTimeoutMillis() {
        if (readTimeout != null) {
            return (int) SECONDS.toMillis(readTimeout);
        } else {
            return null;
        }
    }

    public Integer getConnectTimeoutMillis() {
        if (connectTimeout != null) {
            return (int) SECONDS.toMillis(readTimeout);
        } else {
            return null;
        }
    }
}