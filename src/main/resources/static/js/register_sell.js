const PostFormObj = {
    selectRental() {
        document.getElementById("priceRow").classList.remove("d-none");

        document.getElementById("extensionPriceRow").classList.remove("d-none");
        document.getElementById("depositRow").classList.remove("d-none");
        document.getElementById("rentalPriceHeader").classList.remove("d-none");
        document.getElementById("usedPriceHeader").classList.add("d-none");
    },
    selectUsed() {
        document.getElementById("priceRow").classList.remove("d-none");

        document.getElementById("extensionPrice").value = null;
        document.getElementById("deposit").value = null;

        document.getElementById("extensionPriceRow").classList.add("d-none");
        document.getElementById("depositRow").classList.add("d-none");
        document.getElementById("rentalPriceHeader").classList.add("d-none");
        document.getElementById("usedPriceHeader").classList.remove("d-none");
    },
    /**
     * 전송 실패 등을 이유로 이미 렌탈/중고에 체크된 상태에서 페이지를 열 경우의 처리
     */
    checkAlreadySelected() {
        if (document.getElementById("selectRental").checked) {
            this.selectRental();
        }
        if (document.getElementById("selectUsed").checked) {
            this.selectUsed();
        }
    }
}

const EventObj = {
    /**
     * EventListener들을 등록
     */
    setEventListeners() {
        /**
         * 렌탈/중고 선택시 그에 따른 입력 폼 변경
         */
        document.getElementById("selectRental").addEventListener("change", (evt) => {
            PostFormObj.selectRental();
        });
        document.getElementById("selectUsed").addEventListener("change", (evt) => {
            PostFormObj.selectUsed();
        });

        /**
         * 연장 허용안함/보증금 없음 체크시 입력창 비활성화
         */
        document.getElementById("extensionDisable").addEventListener("change", (evt) => {
            if (evt.currentTarget.checked) {
                document.getElementById("extensionPrice").value = null;
                document.getElementById("extensionPrice").disabled = true;
            } else {
                document.getElementById("extensionPrice").disabled = false;
            }
        });
        document.getElementById("depositDisable").addEventListener("change", (evt) => {
            if (evt.currentTarget.checked) {
                document.getElementById("deposit").value = null;
                document.getElementById("deposit").disabled = true;
            } else {
                document.getElementById("deposit").disabled = false;
            }
        });
    }
}

/**
 * 문서 로딩 후 실행될 함수들
 */
function initConfig() {
    PostFormObj.checkAlreadySelected();
    EventObj.setEventListeners();
}

document.addEventListener("DOMContentLoaded", () => {
    initConfig();
});