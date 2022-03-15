package ru.cbrrate.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CurrencyRate {
	private String name;
	private String birthday;
	private String post; //должность
	private String experienceYear; //стаж

    @JsonCreator
    public CurrencyRate(
    		@JsonProperty("name") String name,
		    @JsonProperty("birthday") String birthday,
		    @JsonProperty("post") String post,
		    @JsonProperty("experienceYear") String experienceYear) {
	    this.name = name;
	    this.birthday = birthday;
	    this.post = post;
	    this.experienceYear = experienceYear;
    }
}
