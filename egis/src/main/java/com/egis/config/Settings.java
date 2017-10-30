package com.egis.config;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@ConfigurationProperties
@Validated
public class Settings {
	
	
	@NotNull
	@Value("${environment.label}")
	private String environmentLabel;
	
	@NotNull
	@Value("${environment.message}")
	private String environmentMessage;

	@NotNull
	@Value("${background.apikey}")
	private String backgroundAPIKey;
	
	@NotNull
	@Value("${background.accountId}")
	private String backgroundAccountId;
	
	
	
	
	public String getBackgroundAPIKey() {
		return backgroundAPIKey;
	}

	public void setBackgroundAPIKey(String backgroundAPIKey) {
		this.backgroundAPIKey = backgroundAPIKey;
	}

	public String getBackgroundAccountId() {
		return backgroundAccountId;
	}

	public void setBackgroundAccountId(String backgroundAccountId) {
		this.backgroundAccountId = backgroundAccountId;
	}

	public String getEnvironmentLabel() {
		return environmentLabel;
	}

	public void setEnvironmentLabel(String environmentLabel) {
		this.environmentLabel = environmentLabel;
	}

	public String getEnvironmentMessage() {
		return environmentMessage;
	}

	public void setEnvironmentMessage(String environmentMessage) {
		this.environmentMessage = environmentMessage;
	}
	

}
