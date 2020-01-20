package com.kiselev.time.view;

import com.kiselev.time.service.ServiceConfiguration;
import com.kiselev.time.view.web.WebViewConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ServiceConfiguration.class, WebViewConfiguration.class})
public class ViewConfiguration {
}
