package com.samples.boot.zookeeper;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.stereotype.Service;

import com.samples.boot.props.Properties;

@Service
public class ZookeeperConfig {

	static Logger logger = Logger.getLogger(ZookeeperConfig.class);

	static ZooKeeper zk = null;

	@PostConstruct
	public void init() throws IOException, KeeperException, InterruptedException {

		logger.info("<<<<<< Zookeper config started (zookeepr must be started in 127.0.0.1:2181) >>>>>");
		zk = new ZooKeeper("127.0.0.1:2181", 20000, new Watcher() {

			@Override
			public void process(WatchedEvent event) {
				logger.info("Zookeper: Connected " + event.toString());

			}

		});
		// Read watcher, make sure these nodes exists before starting
		zk.getData("/zk_test", new EventWatch("/zk_test", "zk_test", true), null);
		zk.getData("/max_limit", new EventWatch("/max_limit", "max_limit", true), null);
	}

	/**
	 * A watcher, print new value and register another watch
	 * 
	 * @author kamoorr
	 *
	 */
	private class EventWatch implements Watcher {

		private String path;
		private String applicationProperty;
		private boolean watchContinue;

		public EventWatch(String path, String appProperty, boolean watchContinue) {
			this.path = path;
			this.applicationProperty = appProperty;
			this.watchContinue = watchContinue;
		}

		@Override
		public void process(WatchedEvent event) {
			try {
				String data = new String(zk.getData(path, false, null));
				logger.info("New Value came in Value = " + data);
				Properties.getInstance().setProperty(applicationProperty, data);
				// Register one more watcher for nexr change
				if (watchContinue) {
					zk.getData(path, this, null);
				}

			} catch (KeeperException | InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
