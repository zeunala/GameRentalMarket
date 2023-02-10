const PromotionObj = {
    /**
     * 프로모션 JSON 데이터에 따라 프로모션 슬라이드 HTML 추가
     * @param promotions filePath와 url값을 가지는 객체의 배열
     * @private
     */
    _showPromotion({promotions}) {
        promotions.forEach(({filePath, url}, idx) => {
            document.querySelector(".carousel-indicators").innerHTML +=
                `<button type="button" data-bs-target="#promotionCarousel" data-bs-slide-to="${idx}" 
                    ${idx == 0 ? `class="active" aria-current="true"` : ``}
                     aria-label="프로모션 슬라이드"></button>`;
            document.querySelector(".carousel-inner").innerHTML +=
                `<div ${idx == 0 ? `class="carousel-item active"` : `class="carousel-item"`}>
                    <a ${url ? `href="${url}"` : ``}>
                        <img src="/${filePath}" class="d-block w-100" alt="프로모션 이미지">
                    </a>
                </div>`;
        });
    },
    /**
     * 프로모션 API 호출
     */
    loadData() {
        fetch('/api/promotionlist')
            .then(response => response.json())
            .then(jsonData => this._showPromotion(jsonData));
    }
}

const ProductObj = {
    /**
     * 현재 보여지게 할 상품들의 categoryId
     * null이면 모든 상품이 보여짐
     * 초기 페이지 로드시 categoryId 파라미터가 있으면 그 값으로 초기화
     */
    _currentCategoryId: Number(new URLSearchParams(location.search).get("categoryId")) || null,
    _currentCount: 0,
    _totalCount: 0,
    _convertPriceText(minRentalPrice, minUsedPrice) {
        if (minRentalPrice) {
            return `&#8361;${minRentalPrice.toLocaleString()}원 / 3주`;
        }
        if (minUsedPrice) {
            return `&#8361;${minUsedPrice.toLocaleString()}원 / 중고`;
        }
        return `재고 없음`;
    },
    _setCountAndMoreButton: function (totalCount, addCount) {
        this._totalCount = totalCount;
        this._currentCount += addCount;

        // 더 조회할 데이터가 남은 경우 더보기 버튼 활성화
        if (this._currentCount < this._totalCount) {
            document.getElementById("showMoreButton").classList.remove("visually-hidden");
        } else {
            document.getElementById("showMoreButton").classList.add("visually-hidden");
        }
    },
    /**
     * 상품 JSON 데이터에 따라 개별 상품 HTML 추가
     * @param totalCount 카테고리의 총 product 개수
     * @param products 상품 정보 객체의 배열
     * @private
     */
    _showProduct({totalCount, products}) {
        this._setCountAndMoreButton(totalCount, products.length);

        products.forEach(({id, title, filePath, minRentalPrice, minUsedPrice}) => {
            document.getElementById("productList").innerHTML +=
                `<div class="col mb-5">
                    <div class="card h-100">
                        <a href="/detail/${id}">
                            <img class="card-img-top" src="/${filePath}" alt="${title} 상품 이미지">
                        </a>
                        <div class="card-body p-4">
                            <div class="text-center">
                                <h5 class="fw-bolder">${title}</h5>
                                ${this._convertPriceText(minRentalPrice, minUsedPrice)}
                            </div>
                        </div>
                        <div class="card-footer text-center p-4 pt-0 border-top-0 bg-transparent">
                            <span><a class="btn btn-outline-info mt-auto" href="/register/sell/${id}">빌려주기</a></span>
                            <span><a class="btn btn-outline-danger mt-auto" href="/detail/${id}">빌려쓰기</a></span>
                        </div>
                    </div>
                </div>`
        });
    },
    /**
     * 다른 카테고리로 변경할 경우 현재 표시중인 상품을 지우고 해당 카테고리의 처음부터 로드
     * @param categoryId 변경할 categoryId
     */
    set currentCategoryId(categoryId) {
        if (this._currentCategoryId === categoryId) {
            return;
        }

        document.getElementById("productList").innerHTML = "";
        this._currentCategoryId = categoryId;
        this._currentCount = 0;
        this.loadData();
    },
    /**
     * 상품 API 호출
     */
    loadData() {
        let fetchUrl = `/api/productlist?start=${this._currentCount}`;
        if (this._currentCategoryId) {
            fetchUrl += `&categoryId=${this._currentCategoryId}`;
        }

        fetch(fetchUrl)
            .then(response => response.json())
            .then(jsonData => this._showProduct(jsonData));
    }
}

const EventObj = {
    /**
     * EventListener들을 등록
     */
    setEventListeners() {
        document.querySelectorAll(".change-category").forEach(e => {
            e.addEventListener("click", () => {
                ProductObj.currentCategoryId = parseInt(e.dataset.categoryId);
            });
        });
        document.getElementById("showMoreButton").addEventListener("click", () => {
            ProductObj.loadData();
        });
    }
}

/**
 * 문서 로딩 후 실행될 함수들
 */
function initConfig() {
    PromotionObj.loadData();
    ProductObj.loadData();
    EventObj.setEventListeners();
}

document.addEventListener("DOMContentLoaded", () => {
    initConfig();
});