package com.subhajit.assignment.pincode;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.subhajit.assignment.autocomplete.IAutoComplete;
import com.subhajit.assignment.autocomplete.util.CsvReaderUtil;
import com.subhajit.assignment.model.Trie;

/**
 * @author Subhajit
 * @since Jul-2019
 * @see com.subhajit.assignment.pincode.PincodeService#getSuggestion
 *
 */
@Component
public class PincodeService implements IAutoComplete {

	private final static Logger LOGGER = LoggerFactory.getLogger(PincodeService.class);

	@Override
	public List<String> getSuggestion(final String word, final int strength) {
		Trie trie = new Trie();
		Optional<List<String>> optionalDistricts = CsvReaderUtil.getDistricts();
		LOGGER.info("Start search for word : {}", word);
		optionalDistricts.ifPresent(list -> list.parallelStream().filter(e -> Objects.nonNull(e)).forEach(e -> {
			LOGGER.info("Inserting word : {}", e);
			trie.insert(e);
		}));
		List<String> autoCompleteList = trie.autocomplete(word);
		LOGGER.info("Autocomplete finishe,found {} number of result", autoCompleteList.size());
		return autoCompleteList.subList(0, Math.min(autoCompleteList.size(), strength));
	}
}
