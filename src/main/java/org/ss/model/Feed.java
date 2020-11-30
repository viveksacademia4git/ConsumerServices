package org.ss.model;

import java.util.Date;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Feed {

	@NonNull
	private String picturelink;

	@NonNull
	private String title;

	@NonNull
	private String browserviewlink;

	@NonNull
	private Date date;

}
