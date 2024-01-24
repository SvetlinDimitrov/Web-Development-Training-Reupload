package com.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.time.Instant;

@WebFilter(urlPatterns = "/*", dispatcherTypes = DispatcherType.REQUEST)
public class LoggingFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization logic (if needed)
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Log information about the request
        Instant start = Instant.now();
        System.out.printf("Request received at: %s%n", start);

        // Continue with the filter chain
        chain.doFilter(request, response);

        Instant end = Instant.now();
        // Log information about the response (after servlet processing)
        System.out.printf("Request received at: %s%n", end);

    }

    public void destroy() {
        // Cleanup logic (if needed)
    }
}
