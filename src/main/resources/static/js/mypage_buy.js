const EventObj = {
    /**
     * EventListener들을 등록
     */
    setEventListeners() {
        /**
         * 물품 정보의 각 행을 누르면 해당 판매글의 상세정보가 아래에 노출된다.
         */
        document.querySelectorAll(".simple-info").forEach(e => {
            e.addEventListener("click", (event) => {
                const detailInfo = event.currentTarget.nextElementSibling;
                if (detailInfo.classList.contains("d-none")) {
                    detailInfo.classList.remove("d-none");
                } else {
                    detailInfo.classList.add("d-none");
                }
            })
        });
    }
}

/**
 * 문서 로딩 후 실행될 함수들
 */
function initConfig() {
    EventObj.setEventListeners();
}

document.addEventListener("DOMContentLoaded", () => {
    initConfig();
});
