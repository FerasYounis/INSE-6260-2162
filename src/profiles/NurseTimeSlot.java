package profiles;

import Enums.AvailableTimeStatusNures;

public class NurseTimeSlot {
	private AvailableTimeStatusNures status;
	private Request request;

	public NurseTimeSlot(AvailableTimeStatusNures status, Request request) {
		this.status = status;
		this.request = request;
	}

	public NurseTimeSlot(AvailableTimeStatusNures status) {
		this(status, null);
	}

	public AvailableTimeStatusNures getStatus() {
		return status;
	}

	public void setStatus(AvailableTimeStatusNures status) {
		this.status = status;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	@Override
	public String toString() {
		return "NurseTimeSlot [status=" + status + ", request=" + request + "]";
	}

}
