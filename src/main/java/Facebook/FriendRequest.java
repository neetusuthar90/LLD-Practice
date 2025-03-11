package Facebook;

import java.util.List;

public class FriendRequest {
    private int requestId;
    private Member requestFrom;
    private Member requestTo;
    private RequestStatus requestStatus;

    public FriendRequest(int requestId, Member requestFrom, Member requestTo) {
        this.requestId = requestId;
        this.requestFrom = requestFrom;
        this.requestTo = requestTo;
        this.requestStatus = RequestStatus.PENDING;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public Member getRequestFrom() {
        return requestFrom;
    }

    public void setRequestFrom(Member requestFrom) {
        this.requestFrom = requestFrom;
    }

    public Member getRequestTo() {
        return requestTo;
    }

    public void setRequestTo(Member requestTo) {
        this.requestTo = requestTo;
    }

    public RequestStatus getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }
}
