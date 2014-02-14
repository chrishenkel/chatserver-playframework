package services;

import org.springframework.stereotype.Service;

import com.google.android.gcm.server.Sender;

@Service
public class MySenderService extends Sender {

	public MySenderService() {
		super("natural-motif-491");
	}
}
