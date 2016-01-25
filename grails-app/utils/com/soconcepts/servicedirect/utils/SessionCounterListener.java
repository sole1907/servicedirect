/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soconcepts.servicedirect.utils;

import java.util.Calendar;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import com.soconcepts.servicedirect.VisitorsCount;

/**
 *
 * @author Soul
 */
public class SessionCounterListener implements HttpSessionListener {

    private static int totalSessions = 0;
    private static int totalActiveSessions = 0;
    private static Calendar today = Calendar.getInstance();

    public static int getTotalActiveSession() {
        return totalActiveSessions;
    }

    public static int getTotalSession() {
        return totalSessions;
    }

    @Override
    public void sessionCreated(HttpSessionEvent arg0) {
        totalActiveSessions++;
        //HttpSession session = arg0.getSession();
        if (Calendar.getInstance().get(Calendar.DAY_OF_MONTH) != today.get(Calendar.DAY_OF_MONTH)) {
            VisitorsCount visitorsCount = new VisitorsCount();
            visitorsCount.setDate(today.getTime());
            visitorsCount.setCount(totalSessions);
            visitorsCount.saveCount();

            today = Calendar.getInstance();
            totalSessions = 0;
        }
        totalSessions++;
        //session.setAttribute("totalActiveSessions", totalActiveSessions);
        //session.setAttribute("totalSessions", totalSessions);*/
        System.out.println("sessionCreated - add one session into counter");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent arg0) {
        if (totalActiveSessions > 0) {
            totalActiveSessions--;
        }
        //HttpSession session = arg0.getSession();
        //session.setAttribute("totalActiveSessions", totalActiveSessions);
        //session.setAttribute("totalSessions", totalSessions);
        System.out.println("sessionDestroyed - deduct one session from counter");
    }
}
