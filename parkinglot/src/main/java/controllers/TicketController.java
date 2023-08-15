package controllers;

import dto.GenerateInvoiceResponse;
import dto.GenerateTicketRequest;
import dto.GenerateTicketResponse;
import exceptions.GateNotFoundException;
import exceptions.NoParkingSpotsAvailableException;
import models.*;
import services.EntryGateService;
import services.ExitGateService;

/**
 * Roles of a controller:
 * 1. To perform validations.
 * 2. Call the correct order of services with appropriate params
 * 3. Render the response object
 */
public class TicketController {
    private EntryGateService entryGateService;
    private ExitGateService exitGateService;

    public TicketController(EntryGateService entryGateService, ExitGateService exitGateService) {

        this.entryGateService = entryGateService;
        this.exitGateService = exitGateService;
    }

    public GenerateTicketResponse generateTicket(GenerateTicketRequest request) throws NoParkingSpotsAvailableException {

        // Validation checks
        if(request.getGate() == null) {
            throw new GateNotFoundException();
        }

        Ticket ticket = entryGateService.createTicket(request.getGate(), request.getVehicle());

        // Render the response
        return GenerateTicketResponse.builder().ticket(ticket).build();
    }

    public GenerateInvoiceResponse generateInvoice(Payment payment, Gate exitGate) {

        Invoice invoice = exitGateService.generateInvoice(payment,exitGate);
        return GenerateInvoiceResponse.builder().invoice(invoice).build();
    }

}
