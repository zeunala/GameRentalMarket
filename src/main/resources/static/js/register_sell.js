const EventObj = {
    /**
     * EventListener들을 등록
     */
    setEventListeners() {
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
    EventObj.setEventListeners();
}

document.addEventListener("DOMContentLoaded", () => {
    initConfig();
});