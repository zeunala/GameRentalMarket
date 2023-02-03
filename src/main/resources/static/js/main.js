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

/**
 * 문서 로딩 후 실행될 함수들
 */
function initConfig() {
    PromotionObj.loadData();
}

document.addEventListener("DOMContentLoaded", () => {
    initConfig();
});