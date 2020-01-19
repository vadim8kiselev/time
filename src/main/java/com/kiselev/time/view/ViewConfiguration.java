package com.kiselev.time.view;

import com.kiselev.time.view.web.WebViewConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({WebViewConfiguration.class})
public class ViewConfiguration {
}
