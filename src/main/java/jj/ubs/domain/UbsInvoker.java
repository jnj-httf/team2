package jj.ubs.domain;

import jj.ubs.domain.infra.UbsResponse;

/**
 * Class responsbile to retrieve the Ubs data from external source.
 */
public interface UbsInvoker {

    /**
     * Retrieve a paginated list of UBSs.
     *
     * @param page The page number.
     * @return An {@link UbsResponse} object with the list of Ubs and pagination data.
     */
    UbsResponse getUbs(int page);

    /**
     * Retrieve a paginated list of UBSs filtered by city.
     *
     * @param page The page number.
     * @return An {@link UbsResponse} object with the list of Ubs and pagination data.
     */
    UbsResponse getUbsByCity(String city, int page);
}
