const PriceCalcObj = {
    /**
     * 연장 안했을 때 기본 렌탈 값
     * @private
     */
    _DEFAULT_RENTAL_PERIOD: 3,

    /**
     * 총 가격(원래 가격 + (연장시 가격) * (연장 기간) + 보증금) 계산
     * @private
     */
    _calcTotalPrice() {
        let totalPrice = Number.parseInt(document.getElementById("priceHiddenValue").value);
        if (document.getElementById("extensionPriceHiddenValue")) {
            const extensionPrice = Number.parseInt(document.getElementById("extensionPriceHiddenValue").value);
            const rentalPeriod = Number.parseInt(document.getElementById("periodSelect").value);
            totalPrice += extensionPrice * (rentalPeriod - this._DEFAULT_RENTAL_PERIOD);
        }
        if (document.getElementById("depositHiddenValue")) {
            totalPrice += Number.parseInt(document.getElementById("depositHiddenValue").value);
        }
        return totalPrice;
    },

    /**
     * 총 가격 계산값을 갱신
     */
    showTotalPrice() {
        const totalPrice = this._calcTotalPrice();
        document.getElementById("totalPriceDisplay").innerText = `${totalPrice.toLocaleString()}`;
        document.getElementById("totalPrice").value = totalPrice;
    }
}

const EventObj = {
    /**
     * EventListener들을 등록
     */
    setEventListeners() {
        if (document.getElementById("periodSelect")) {
            document.getElementById("periodSelect").addEventListener("change", () => {
                PriceCalcObj.showTotalPrice();
            });
        }
    }
}

/**
 * 문서 로딩 후 실행될 함수들
 */
function initConfig() {
    PriceCalcObj.showTotalPrice();
    EventObj.setEventListeners();
}

document.addEventListener("DOMContentLoaded", () => {
    initConfig();
});