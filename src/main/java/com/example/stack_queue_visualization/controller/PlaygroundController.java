package com.example.stack_queue_visualization.controller;


import com.example.stack_queue_visualization.dto.StructureState;
import com.example.stack_queue_visualization.service.PlaygroundService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PlaygroundController {

    private final PlaygroundService service;

    public PlaygroundController(PlaygroundService service) {
        this.service = service;
    }

    // ---- STACK ----

    @PostMapping("/stack/{impl}/push")
    public StructureState pushToStack(
            @PathVariable String impl,
            @RequestParam int value
    ) {
        return service.pushToStack(impl, value);
    }

    @PostMapping("/stack/{impl}/pop")
    public StructureState popFromStack(@PathVariable String impl) {
        return service.popFromStack(impl);
    }

    @GetMapping("/stack/{impl}/state")
    public StructureState getStackState(@PathVariable String impl) {
        return service.getStackState(impl);
    }

    // ---- QUEUE ----

    @PostMapping("/queue/{impl}/enqueue")
    public StructureState enqueueToQueue(
            @PathVariable String impl,
            @RequestParam int value
    ) {
        return service.enqueueToQueue(impl, value);
    }

    @PostMapping("/queue/{impl}/dequeue")
    public StructureState dequeueFromQueue(@PathVariable String impl) {
        return service.dequeueFromQueue(impl);
    }

    @GetMapping("/queue/{impl}/state")
    public StructureState getQueueState(@PathVariable String impl) {
        return service.getQueueState(impl);
    }
}

