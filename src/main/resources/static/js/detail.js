const EventObj = {
    /**
     * EventListener들을 등록
     */
    setEventListeners() {
        /**
         * 렌탈하기/중고구매 버튼을 누를 경우 하단에 판매글 정보들이 노출된다.
         */
        document.getElementById("selectRental").addEventListener("click", () => {
            document.getElementById("rentalPosts").classList.remove("d-none");
            document.getElementById("usedPosts").classList.add("d-none");
        });
        document.getElementById("selectUsed").addEventListener("click", () => {
            document.getElementById("usedPosts").classList.remove("d-none");
            document.getElementById("rentalPosts").classList.add("d-none");
        });

        /**
         * 하단 판매글의 각 행을 누르면 해당 판매글의 상세정보가 아래에 노출된다.
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
