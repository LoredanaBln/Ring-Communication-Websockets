# Ring Communication

## What is a Ring Topology?
Ring topology is a type of network configuration where devices are connected in a circular
manner, forming a closed loop. In this setup, each device is connected to exactly two other
devices, creating a continuous pathway for data transmission. This means that data travels in
only one direction around the ring, passing through each device until it reaches its destination.

<p align="center">
  <img src="https://github.com/user-attachments/assets/d2bbf255-a6ef-4f76-a5ac-7779c7b8d247" alt="ring"  alt="ring" width="500"/>
</p>

## How does the Ring Topology work?
In a ring topology, data is transmitted from one device to the next in a sequential manner.
When you send data from your device, it travels to the next device in the ring, and that device
passes it along to the next device until it reaches the intended recipient. Each device in the ring
acts as a repeater, regenerating and retransmitting the data, ensuring that it continues to flow
around the ring.

## Project requirements
The purpose of the project is to build a ring topology where three computers form a
unidirectional loop where one initiates communication by sending ’1’, and each device increments
and forwards the value until it reaches ’100’

## References
- [What is Ring Topology? – Lenovo](https://www.lenovo.com/us/en/glossary/what-is-ring-topology/)

