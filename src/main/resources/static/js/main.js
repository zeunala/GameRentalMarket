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
    _currentCategoryId: null,
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
    /**
     * 상품 JSON 데이터에 따라 개별 상품 HTML 추가
     * @param totalCount 카테고리의 총 product 개수
     * @param products 상품 정보 객체의 배열
     * @private
     */
    _showProduct({totalCount, products}) {
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
     * 상품 API 호출
     */
    loadData() {
        fetch('/api/productlist')
            .then(response => response.json())
            .then(jsonData => this._showProduct(jsonData));
    }
}

/**
 * 문서 로딩 후 실행될 함수들
 */
function initConfig() {
    PromotionObj.loadData();
    ProductObj.loadData();
}

document.addEventListener("DOMContentLoaded", () => {
    initConfig();
});