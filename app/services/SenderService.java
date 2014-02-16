package services;

import org.springframework.stereotype.Service;

import com.google.android.gcm.server.Sender;

@Service
public class SenderService extends Sender {

	public SenderService() {
		super("natural-motif-491");
	}
}
