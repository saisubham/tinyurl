from locust import HttpUser, run_single_user, task
import uuid


class LoadTests(HttpUser):
    host = "http://localhost:9000"

    @task
    def t1(self):
        url = f"https://www.{str(uuid.uuid4())[:5]}.com"
        payload = {"longUrl": url}
        self.client.post("/", json=payload)

if __name__ == "__main__":
    run_single_user(LoadTests)
