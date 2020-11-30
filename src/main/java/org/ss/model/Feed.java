package org.ss.model;

import java.util.Date;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Feed {

	@NonNull
	private String title;

	@NonNull
	private Date date;

	@NonNull
	private String browserviewlink;

	@NonNull
	private String picturelink;

}
