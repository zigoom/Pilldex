package com.fiveguys.pilldex.detail.cmn;

import java.sql.SQLException;
import java.util.List;

import com.fiveguys.pilldex.domain.PillVO;

public interface WorkDiv<T> {
    
    List<PillVO> parseDataFromDbToName(T inVO) throws SQLException;
}
