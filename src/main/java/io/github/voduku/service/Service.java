package io.github.voduku.service;

import io.github.voduku.model.AbstractSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

/**
 * Basic CRUD functionalities with options to customizable search to reduce memory foot print
 *
 * @param <REQUEST>  Request Type
 * @param <RESPONSE> Response Type
 * @param <KEY>      Entity Key Type
 * @author VuDo
 * @since 1.0.0
 */
public interface Service<REQUEST, RESPONSE, SEARCH extends AbstractSearch<?>, KEY> {

  boolean exists(KEY key);

  RESPONSE create(KEY key, REQUEST request);

  RESPONSE update(KEY key, REQUEST response);

  RESPONSE get(KEY key);

  RESPONSE get(KEY key, SEARCH parameters);

  void delete(KEY key);

  Slice<RESPONSE> search(SEARCH parameters, Pageable pageable);

  Page<RESPONSE> searchPage(SEARCH parameters, Pageable pageable);
}
