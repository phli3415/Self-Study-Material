from openai import OpenAI
client = OpenAI()

response = client.responses.create(
    model="gpt-5",
    input="What is llm"

)

print(response.output_text)