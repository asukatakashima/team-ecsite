package jp.co.internous.lollipop.model.mapper;

import java.util.List;
import java.util.Map;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import jp.co.internous.lollipop.model.domain.dto.PurchaseHistoryDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper 
//DBテーブルとアクセスするインターフェース
public interface TblPurchaseHistoryMapper {
	int insert(Map<String,Object> parameter);

	List<PurchaseHistoryDto> findByUserId(@Param("userId")int userId);
	
	//論理削除するUpdate文
	@Update("UPDATE tbl_purchase_history SET status = 0,updated_at = now() WHERE user_Id = #{userId}")
	int logicalDeleteByUserId(@Param("userId") int userId);
}
