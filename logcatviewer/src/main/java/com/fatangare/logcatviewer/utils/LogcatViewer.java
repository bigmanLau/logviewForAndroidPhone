/**
 * Copyright (C) 2016  Sandeep Fatangare <sandeep@fatangare.info>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.fatangare.logcatviewer.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.widget.Toast;

import com.fatangare.logcatviewer.service.LogcatViewerFloatingView;

import wei.mark.standout.StandOutWindow;

/**
 * This class will launch {@link LogcatViewerFloatingView} view.
 */
public class LogcatViewer {
    /**
     * Launch {@link LogcatViewerFloatingView} view.
     * @param context context.
     */

    public static void showLogcatLoggerView(Context context,String packageName){

        if (Build.VERSION.SDK_INT >= 23) {
            if (Settings.canDrawOverlays(context)) {
                openLoggerView(context, packageName);
            } else {
                //若没有权限，提示获取.
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
                Toast.makeText(context, "需要取得权限以使用悬浮窗", Toast.LENGTH_SHORT).show();
                context.startActivity(intent);
            }
        } else {
            //SDK在23以下，不用管.
            openLoggerView(context,packageName);
        }

    }

    private static void openLoggerView(Context context,String packageName) {
        StandOutWindow.closeAll(context, LogcatViewerFloatingView.class);
        StandOutWindow
                .show(context, LogcatViewerFloatingView.class, StandOutWindow.DEFAULT_ID,packageName);
    }

    /**
     * Close  {@link LogcatViewerFloatingView} view.
     *
     * @param context context.
     */
    public static void closeLogcatLoggerView(Context context) {
        StandOutWindow.closeAll(context, LogcatViewerFloatingView.class);
    }




}
