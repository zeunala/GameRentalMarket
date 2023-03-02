const DealObj = {
    /**
     * alert창 확인 선택시 현재 페이지의 deal을 삭제한다.
     */
    deleteDeal() {
        // deal/sell/{dealId}에서 dealId를 취한다.
        const dealId = window.location.pathname.split("/")[3];
        if (confirm("정말로 현재 거래를 취소하시겠습니까? 삭제 후에는 복구할 수 없으며, 작성한 판매글은 유지됩니다.")) {
            fetch(`/deal/${dealId}`, {
                method: "DELETE",
            }).then(() => {
                window.location.href = "/mypage/sell";
            });
        }
    }
}

const EventObj = {
    /**
     * EventListener들을 등록
     */
    setEventListeners() {
        /**
         * 글 삭제 버튼을 누르면 확인창을 띄우고, 확인을 누르면 해당 판매글이 삭제된다.
         */
        document.querySelectorAll(".deal-delete").forEach(e => {
            e.addEventListener("click", () => {
                DealObj.deleteDeal();
            });
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
