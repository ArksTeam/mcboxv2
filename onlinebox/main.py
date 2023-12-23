import os
import socket

class launcher:
    def __init__(self, group_name="mcbox", server_ip="n2nserver.awaland.xyz"):
        self.n2n_path = "/x86/v2"
        self.group_name = group_name
        self.server_ip = self.nslookup(server_ip)[0]
        self.community_name = self.group_name

    def nslookup(domain):
        try:
            ip_list = []
            addr_info = socket.getaddrinfo(domain, None)
            for addr in addr_info:
                if addr[0] == socket.AF_INET:
                    ip_list.append(addr[4][0])
        except:
            return ['0.0.0.0']
    
    def start(self, password):
        supernode_ip = self.server_ip + ":7777"
        cmd = f"{self.n2n_path} -c {self.community_name} -k {password} -l {supernode_ip}"
        os.system(cmd)

