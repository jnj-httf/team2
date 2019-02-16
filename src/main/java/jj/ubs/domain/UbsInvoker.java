package jj.ubs.domain;

import jj.ubs.domain.infra.UbsResponse;

public interface UbsInvoker {

    UbsResponse getUbs(int page);

    UbsResponse getUbsByCity(String city, int page);
}
