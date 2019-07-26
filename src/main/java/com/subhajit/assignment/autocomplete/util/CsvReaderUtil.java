package com.subhajit.assignment.autocomplete.util;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.subhajit.assignment.pincode.Pincode;

/**
 * @author Subhajit
 * @since Jul-2019
 * @see com.subhajit.assignment.autocomplete.util#getDistricts
 *
 */

public final class CsvReaderUtil {

	private final static Logger LOGGER = LoggerFactory.getLogger(CsvReaderUtil.class);

	private CsvReaderUtil() {

	}

	public static Optional<List<String>> getDistricts() {
		try (Reader reader = Files.newBufferedReader(
				Paths.get(ClassLoader.getSystemResource("Pincode_30052019.csv").toURI()), StandardCharsets.UTF_8);) {
			CsvToBean<Pincode> csvToBean = new CsvToBeanBuilder(reader).withSkipLines(0).withType(Pincode.class)
					.withIgnoreLeadingWhiteSpace(true).build();

			Iterator<Pincode> csvUserIterator = csvToBean.iterator();
			List<String> districtList = new ArrayList<>();
			while (csvUserIterator.hasNext()) {
				districtList.add(csvUserIterator.next().getDistrict());
			}
			return Optional.of(new ArrayList<>(new HashSet<>(districtList)));
		} catch (IOException | URISyntaxException e) {
			LOGGER.error("Error while reading from csv {}", e.getMessage());
		}
		return Optional.empty();
	}
}
