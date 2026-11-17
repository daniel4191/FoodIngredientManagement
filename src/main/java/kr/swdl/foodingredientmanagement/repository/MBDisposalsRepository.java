package kr.swdl.foodingredientmanagement.repository;

import kr.swdl.foodingredientmanagement.dto.HQDisposalDTO;
import kr.swdl.foodingredientmanagement.dto.HqDisposalSerachFilterDTO;
import kr.swdl.foodingredientmanagement.dto.StoreDisposalDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MBDisposalsRepository {
    public List<HQDisposalDTO> getHqDisposals(HqDisposalSerachFilterDTO hqDisposalSerachFilterDTO);

    public List<StoreDisposalDTO> getStoreDisposals(HqDisposalSerachFilterDTO hqDisposalSerachFilterDTO);

    public int countByTodayDisposed();

    public int sumByTodayDisposedPrice();

    public int countNeedToConfirmByStoreId(int storeId);
}
