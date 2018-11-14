package sherybedrock.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sherybedrock.Notification;
import sherybedrock.services.NotificationService;

import java.util.List;
import java.util.Objects;

@Controller
public class MainController {

    @Autowired
    private NotificationService notificationService;

    /**
     * GET  /  -> show the index page.
     */
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    /**
     * GET  /notifications  -> show the notifications page.
     */
    @RequestMapping("/room1")
    public String room1() {
        return "room1";
    }

    /**
     * GET  /notifications  -> show the notifications page.
     */
    @RequestMapping("/room2")
    public String room2() {
        return "room2";
    }

    /**
     * GET  /notifications  -> show the notifications page.
     */
    @RequestMapping("/room3")
    public String room3() {
        return "room3";
    }

    /**
     * POST  /some-action  -> do an action.
     * <p>
     * After the action is performed will be notified User.
     */
    @RequestMapping(value = "/some-action", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> someAction(@RequestBody List<Room> roomsData) {
        // Send the notification to "admin" (by username)

        roomsData.stream()
                .filter(room -> Objects.nonNull(room.getNotification()))
                .forEach(room -> notificationService.notify(new Notification(room.getRoomId(), room.getNotification()), "admin"));

        // Return an http 200 status code
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
