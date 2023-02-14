const PostObj = {
    /**
     * HTML화면에서 post에 해당하는 판매글 목록을 삭제한다.
     * @param postId
     * @private
     */
    _deletePostHtml(postId) {
        document.querySelectorAll(`[data-post-info-id='${postId}']`).forEach(e => {
            e.remove();
        });
        document.getElementById("registeringPostCount").innerText =
            (parseInt(document.getElementById("registeringPostCount").innerText) - 1).toString();
    },
    /**
     * alert창 확인 선택시 post 삭제 후 화면에서 제거한다.
     * @param postId 삭제할 글 번호
     */
    deletePost(postId) {
        if (confirm("정말로 글을 삭제하시겠습니까? 삭제 후에는 복구할 수 없습니다.")) {
            fetch(`/post/${postId}`, {
                method: "DELETE",
            }).then(response => {
                if (response.ok) {
                    this._deletePostHtml(postId);
                }
                return response.json();
            }).then(jsonData => alert(jsonData.message));
        }
    }
}

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
            });
        });

        /**
         * 글 삭제 버튼을 누르면 확인창을 띄우고, 확인을 누르면 해당 판매글이 삭제된다.
         */
        document.querySelectorAll(".post-delete").forEach(e => {
            e.addEventListener("click", (event) => {
                PostObj.deletePost(event.currentTarget.dataset.postDeleteId);
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
