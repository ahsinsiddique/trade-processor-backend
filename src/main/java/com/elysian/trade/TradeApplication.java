package com.elysian.trade;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@org.springframework.context.annotation.Configuration
@SpringBootApplication
@EntityScan(basePackageClasses = { TradeApplication.class, Jsr310JpaConverters.class })
public class TradeApplication {

	@Value("${socket.server.host}")
	private String host;

	@Value("${socket.server.port}")
	private Integer port;

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setSkipNullEnabled(true);

		return modelMapper;
	}

	@Bean
	public SocketIOServer socketIOServer() {
		Configuration config = new Configuration();
		config.setHostname(host);
		config.setPort(port);
		return new SocketIOServer(config);
	}

	public static void main(String[] args)
	{
		SpringApplication.run(TradeApplication.class, args);
	}

}
