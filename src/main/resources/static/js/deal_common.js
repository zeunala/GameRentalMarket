/**
 * alert창 확인 선택시 컨트롤러에게 거래글 상태 변경 요청을 한다.
 * @param {string} action 요청할 action
 * @param {string} alertAction alert으로 표시할 때 사용할 행위
 */
function sendAction(action, alertAction) {
    // deal/buy/{dealId}, deal/sell/{dealId} 에서 dealId를 취한다.
    const dealId = window.location.pathname.split("/")[3];
    if (confirm(`정말로 ${alertAction} 하시겠습니까?`)) {
        fetch(`/deal/${dealId}?action=${action}`, {
            method: "PATCH",
        }).then(() => {
            window.location.reload();
        });
    }
}
