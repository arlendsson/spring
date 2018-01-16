package com.my.framework.mypage;

import org.apache.ibatis.type.Alias;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Data @Getter @Setter
@Alias("BoardVo")
public class BoardVo {
	private int seq;
	private String title;
	private String content;
	private String regId;
	private String modId;
	private String regDate;
	private String modDate;
	private String count;

	private String page;
	private String begin;
	private String end;

	private String rnum;

//	private String searchCount;
//	private String totalCount;





//	https://gist.github.com/s20307/abfc1098bda329e34360
	private static final int DEFAULT_COUNT_PER_PAGE = 2;// 10	//한화면에 보여질 item row 수
	private static final int DEFAULT_PAGE_PER_BLOCK = 3;// 10	//페이지블럭에 보일 페이지 수 [1] [2] [3] == '3'

	@Getter @Setter
	private int countPerPage = DEFAULT_COUNT_PER_PAGE;
	@Getter @Setter
	private int pagePerBlock = DEFAULT_PAGE_PER_BLOCK;

	@Getter
	private int totalCount;
	@Getter
	private int currentPage;
	@Getter
	private int prevBlockPage;
	@Getter
	private int beginPage;
	@Getter
	private int endPage;
	@Getter
	private int nextBlockPage;
	@Getter
	private int totalPage;

	public void setTotalCount(int totalCount) {
		init(totalCount, this.currentPage);
		calculatePaging();
	}

	public void setCurrentPage(int currentPage) {
		init(this.totalCount, currentPage);
		calculatePaging();
	}

	public boolean hasPrevBlockPage() {
		return this.prevBlockPage > 0;
	}

	public boolean hasNextBlockPage() {
		return this.nextBlockPage > 0;
	}

	//생성자
	public BoardVo(int totalCount, int currentPage) {
		init(totalCount, currentPage);
		calculatePaging();
	}

	private void init(int totalCount, int currentPage) {
		this.totalCount = totalCount;
		this.currentPage = currentPage;
	}

	private void calculatePaging() {
		if (this.totalCount % this.countPerPage == 0) {
			this.totalPage = this.totalCount / this.countPerPage;
		} else {
			this.totalPage = this.totalCount / this.countPerPage + 1;
		}

		if (currentPage > totalPage) {
			return;
		}

		int totalBlock = 1;

		if (this.totalPage % this.pagePerBlock == 0) {
			totalBlock = this.totalPage / this.pagePerBlock;
		} else {
			totalBlock = this.totalPage / this.pagePerBlock + 1;
		}

		int block = 1;
		if (this.currentPage % this.pagePerBlock == 0) {
			block = this.currentPage / this.pagePerBlock;
		} else {
			block = this.currentPage / this.pagePerBlock + 1;
		}

		this.beginPage = (block - 1) * this.pagePerBlock + 1;
		this.endPage = block * this.pagePerBlock;

		if (block >= totalBlock) {
			this.endPage = this.totalPage;
		}

		if (block > 1) {
			this.prevBlockPage = this.beginPage - 1;
		}

		if (block < totalBlock) {
			this.nextBlockPage = this.endPage + 1;
		}
	}

	public BoardVo() {
		//super();
	}
}
